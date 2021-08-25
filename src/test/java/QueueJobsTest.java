import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QueueJobsTest {

    private static Stream<Arguments> jobsProvider() {
        return Stream.of(
                Arguments.of(new String[]{"3-5", "2-5", "2-4", "7-9"}, 3),
                Arguments.of(new String[]{"1-3", "3-4", "7-9"}, 1),
                Arguments.of(new String[]{"1-3", "2-4", "2-9"}, 3),
                Arguments.of(new String[]{}, 0),
                Arguments.of(new String[]{"1-8"}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("jobsProvider")
    void givenJobsList_whenGetMinWorkers_thenReturnExpected(String[] jobsList, int expected) {
        int workers = getMinWorkers(jobsList);
        assertEquals(expected, workers);
    }

    private int getMinWorkers(String[] jobsList) {
        int workers = 0;
        if (jobsList.length == 0) {
            return workers;
        }
        int time = getInitTime(jobsList);
        int lastTime = getLastTime(jobsList);
        Integer[] queueJobs = new Integer[jobsList.length];
        do {
            for (String job : jobsList) {
                addJobToQueue(job, queueJobs, time);
                removeJobFromQueue(job, queueJobs, time);
            }
            int queueSize = getNotNullElements(queueJobs);
            if (queueSize > workers) {
                workers = queueSize;
            }
            time++;
        } while (time <= lastTime);
        return workers;
    }

    private void removeJobFromQueue(String job, Integer[] queueJobs, int time) {
        if (getEndJobTime(job) == time) {
            removeJobsFromQueue(getEndJobTime(job), queueJobs);
        }
    }

    private void removeJobsFromQueue(int endJobTime, Integer[] queueJobs) {
        for (int i = 0; i < queueJobs.length; i++) {
            if (queueJobs[i] != null && queueJobs[i] == endJobTime) {
                queueJobs[i] = null;
                break;
            }
        }
    }

    private void addJobToQueue(String job, Integer[] queueJobs, int time) {
        if (getStartJobTime(job) == time) {
            addJobToQueue(getEndJobTime(job), queueJobs);
        }
    }

    private void addJobToQueue(int job, Integer[] queueJobs) {
        for (int i = 0; i < queueJobs.length; i++) {
            if (queueJobs[i] == null) {
                queueJobs[i] = job;
                break;
            }
        }
    }

    private int getInitTime(String[] jobsList) {
        int initTime = getStartJobTime(jobsList[0]);
        for (String job : jobsList) {
            int startJobTime = getStartJobTime(job);
            if (initTime > startJobTime) {
                initTime = startJobTime;
            }
        }
        return initTime;
    }

    private int getLastTime(String[] jobsList) {
        int lastTime = getEndJobTime(jobsList[0]);
        for (String job : jobsList) {
            int endJobTime = getEndJobTime(job);
            if (lastTime < endJobTime) {
                lastTime = endJobTime;
            }
        }
        return lastTime;
    }

    private int getStartJobTime(String job) {
        String[] split = job.split("-");
        return Integer.parseInt(split[0]);
    }

    private int getEndJobTime(String job) {
        String[] split = job.split("-");
        return Integer.parseInt(split[1]);
    }

    private int getNotNullElements(Integer[] jobList) {
        int count = 0;
        for (Integer job : jobList) {
            if (job != null) {
                count++;
            }
        }
        return count;
    }
}

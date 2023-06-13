#include <stdio.h>
#include <stdlib.h>
#include <errno.h>
#include <ctime>

enum {SECS_TO_SLEEP = 3, NSEC_TO_SLEEP = 125};

int main() {
    struct timespec remaining, request = {SECS_TO_SLEEP,  NSEC_TO_SLEEP};


    printf("Started loop..\n");
    for (int i = 0; i < 10; ++i) {
        printf("Iteration - %d\n", i);
        if (i == 4) {
            printf("Sleeping ....\n");

            errno = 0;
            if (nanosleep(&request, &remaining) == -1) {
                switch (errno) {
                    case EINTR:
                        printf("interrupted by a signal handler\n");
                        exit(EXIT_FAILURE);
                    case EINVAL:
                        printf("tv_nsec - not in range or tv_sec is negative\n");
                        exit(EXIT_FAILURE);
                    default:
                        perror("nanosleep");
                        exit(EXIT_FAILURE);
                }
            }
        }
    }

    exit(EXIT_SUCCESS);
}
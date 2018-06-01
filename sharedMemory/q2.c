#include<sys/shm.h>
#include<sys/ipc.h>
#include<stdio.h>
#include<stdlib.h>
#include<time.h>


int main(){
	key_t key = 1234567890;
	int flag = IPC_CREAT | 0666;
	int buf_size = sizeof(int);
	int id;
	int *data;


	if((id = shmget(key, buf_size, flag)) < 0){
		printf("\nError getting shared memory\n");
		exit(1);
	}

	if((data = shmat(id, NULL, 0)) == (int *)-1){
		printf("\nError attaching to shared memory\n");
		exit(1);
	}
	srand(time(NULL));
	*data = rand() % 10;
	printf("\n%d\n",*data);
	if((shmdt(data)) == -1){
		printf("\nError detaching from shared memory\n");
	}
	exit(0);
}

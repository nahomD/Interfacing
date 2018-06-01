#include<stdio.h>
#include<sys/ipc.h>
#include<sys/shm.h>
#include<stdlib.h>
int main(){
	key_t key = 1234567890;
	int buf_size = sizeof(int);
	int id;
	int *data;

	if((id = shmget(key,buf_size,0666)) < 0){
		printf("\nError getting shared memory\n");
		exit(1);
	}

	if((data = shmat(id, NULL, 0)) == (int *)-1){
		printf("\nError attaching to share memory\n");
		exit(1);
	}

	//*data = 10;
	if(*data % 2 == 0){
		printf("\nThe value %d is even\n", *data);
	}else{
		printf("\nThe value %d is odd\n", *data);
	}

	if(shmdt(data) == -1){
		printf("\nError detaching\n");
		exit(1);
	}

	if((shmctl(id,IPC_RMID, 0)) == -1){
		printf("\nError removing id\n");
		exit(1);
	}

	exit(0);
}

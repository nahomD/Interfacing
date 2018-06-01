#include<stdio.h>
#include<unistd.h>
#include<string.h>
#include<wait.h>

#define READ 0
#define WRITE 1
int main(){
	int fd[2];
	int fd1[2];
	char *message = "Hello from your dady";
	char *message2 = "Hello from your son";
	char buffer_2[1024];
	char buffer[1024];
	pipe(fd);
	pipe(fd1);
	if(fork() != 0){
		printf("\nMessage from dady\n");
		write(fd[WRITE],message,strlen(message)+1);
		read(fd1[READ],buffer_2,strlen(message2)+1);
		printf("\n%s\n", buffer_2);
		wait(NULL);
	}else{
		printf("\nReceiving message\n");
		read(fd[READ],&buffer,strlen(message)+1);
		write(fd1[WRITE],message2,strlen(message2)+1);
		printf("\n%s\n",buffer);
	}

	return 0;
}

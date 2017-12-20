import os 
import paramiko
ssh=paramiko.SSHClient()
ssh.set_missing_host_key_policy(paramiko.AutoAddPolicy())
ssh.connect('192.168.232.133',username="alane",password="debian")
sftp=ssh.open_sftp()
localpath='/home/alane/abc.txt'
remotepath='/etc/default/abc.txt'
sftp.put(localpath, remotepath)
sftp.close()
ssh.close()
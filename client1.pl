use IO::Socket::INET;

$|=1;

my $socket = new IO::Socket::INET(
	PeerHost=>'192.168.220.132',
	PeerPort=>'7777',
	Proto =>'tcp',
);
die "cannot connect to the server $!\n" unless $socket;
print "connected to the server\n";

my $req = 'hye';
my $size = $socket->send($req);
print "sent data of length $size\n";

shutdown($socket, 1);

my $response = "";
$socket ->recv($response, 1024);
print "received response: $response\n";

$socket->close();

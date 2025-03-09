from twisted.internet import protocol, reactor


class Knock(protocol.Protocol):
    def dataReceived(self, data):
        print('Client:', data)

        if data.startswith("Knock knock".encode('utf-8')):
            response = "Who's there?".encode('utf-8')
        else:
            response = data + " who?".encode('utf-8')

        print('Server:', response)
        self.transport.write(response)


class KnockFactory(protocol.Factory):
    def buildProtocol(self, addr):
        return Knock()


if __name__ == '__main__':
    reactor.listenTCP(8000, KnockFactory())
    reactor.run()
        

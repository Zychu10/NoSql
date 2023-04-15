package com.example.NBD

import com.example.NBD.Client.Client
import com.example.NBD.Client.ClientRepository
import com.example.NBD.Client.ClientService
import com.example.NBD.Client.Exceptions.ClientNotFoundException
import spock.lang.Specification
import spock.lang.Subject

class ClientServiceTest extends Specification{
    def clientRepository = Mock(ClientRepository)

    @Subject
    def clientService = new ClientService(clientRepository)

    def "Should return ClientNotFoundException for Client which does not exist"() {
        given: "clientId"
        def clientId = 2

        when: "fetchClient method returns optional.empty"
        clientRepository.findById(clientId) >> Optional.empty()
        clientService.fetchClient(clientId)

        then: "ClientNotFoundException is thrown"
        thrown(ClientNotFoundException)
    }

    def "Should return client"() {
        given: "clientId"
        def clientId = 1

        and: "Client"
        Client client = new Client(clientId, "Krzysztof", "Kaczmarski")

        and: "fetchClient method returns user with given id"
        clientService.fetchClient(clientId) >> client
        clientRepository.findById(clientId) >> Optional.of(client)

        when: "fetchClient method is called on existing client"
        def result = clientService.fetchClient(clientId)

        then: "fetchClient method returns client"
        result == client

    }


}

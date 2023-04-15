package com.example.NBD

import com.example.NBD.Room.Exceptions.RoomNotFoundException
import com.example.NBD.Room.Room
import com.example.NBD.Room.RoomRepository
import com.example.NBD.Room.RoomService
import spock.lang.Specification
import spock.lang.Subject

class RoomServiceTest extends Specification{
    def roomRepository = Mock(RoomRepository)

    @Subject
    def roomServices = new RoomService(roomRepository)

    def "Should return RoomNotFoundException for Room which does not exist"(){
        given: "roomId"
        def roomNumber = 2

        when: "add room method returns optional.empty"
        roomRepository.findByRoomNumber(roomNumber) >> Optional.empty()
        roomServices.findRoom(roomNumber)

        then: "RoomNotFoundException is thrown"
        thrown(RoomNotFoundException)
    }

    def "Should return room"(){
        given: "expected room"
        def expectedRoom = buildExpectedRoom()

        and: "findRoom returns expected room"
        roomServices.findRoom(expectedRoom.roomNumber) >> expectedRoom
        roomRepository.findByRoomNumber(expectedRoom.roomNumber) >> Optional.of(expectedRoom)

        when: "findRoom is called on existing room"
        def result = roomServices.findRoom(expectedRoom.roomNumber)

        then: "findRoom returns room"
        result == expectedRoom

    }

    def buildExpectedRoom() {
        Room.builder()
        .id(1)
        .roomNumber(10)
        .roomCapacity(2)
        .roomPrice(50.0)
        .isRent(false)
        .build()

    }
}



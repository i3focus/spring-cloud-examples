package br.com.i3focus.consumer.resource

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface SignalDataRepository : MongoRepository<SignalDocument, String>
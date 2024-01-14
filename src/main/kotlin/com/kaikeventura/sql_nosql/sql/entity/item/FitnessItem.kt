package com.kaikeventura.sql_nosql.sql.entity.item

import com.kaikeventura.sql_nosql.sql.entity.BaseEntity
import com.kaikeventura.sql_nosql.sql.entity.Item
import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToOne
import java.util.*

@Entity(name = "fitness_item")
class FitnessItem(
    @Id
    val id: UUID,
    val price: Long,

    @OneToOne(cascade = [CascadeType.MERGE], mappedBy = "fitnessItem")
    val item: Item
) : BaseEntity()

fun aFitnessItem(
    price: Long,
    item: Item
) = FitnessItem(
    id = UUID.randomUUID(),
    price = price,
    item = item
)

package com.kaikeventura.sql_nosql.sql.entity.item

import com.kaikeventura.sql_nosql.faker
import com.kaikeventura.sql_nosql.sql.entity.BaseEntity
import com.kaikeventura.sql_nosql.sql.entity.Item
import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToOne
import java.util.*

@Entity(name = "hardware_item")
class HardwareItem(
    @Id
    val id: UUID,
    val price: Long,
    val name: String = faker.harryPotter().character(),
    val type: String = faker.harryPotter().house(),

    @OneToOne(cascade = [CascadeType.MERGE], mappedBy = "hardwareItem")
    val item: Item
) : BaseEntity()

fun aHardwareItem(
    price: Long,
    item: Item
) = HardwareItem(
    id = UUID.randomUUID(),
    price = price,
    item = item
)

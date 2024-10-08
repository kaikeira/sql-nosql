package com.kaikeventura.sql_nosql.sql.entity.item

import com.kaikeventura.sql_nosql.faker
import com.kaikeventura.sql_nosql.sql.entity.BaseEntity
import com.kaikeventura.sql_nosql.sql.entity.Item
import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToOne
import java.util.*

@Entity(name = "software_item")
class SoftwareItem(
    @Id
    val id: UUID,
    val price: Long,
    val name: String = faker.hacker().abbreviation(),

    @OneToOne(cascade = [CascadeType.MERGE], mappedBy = "softwareItem")
    val item: Item
) : BaseEntity()

fun aSoftwareItem(
    price: Long,
    item: Item
) = SoftwareItem(
    id = UUID.randomUUID(),
    price = price,
    item = item
)
package com.kaikeventura.sql_nosql.sql.entity.item

import com.kaikeventura.sql_nosql.faker
import com.kaikeventura.sql_nosql.sql.entity.BaseEntity
import com.kaikeventura.sql_nosql.sql.entity.Item
import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToOne
import java.util.*

@Entity(name = "clothing_item")
class ClothingItem(
    @Id
    val id: UUID,
    val price: Long,
    val name: String = faker.artist().name(),

    @OneToOne(cascade = [CascadeType.MERGE], mappedBy = "clothingItem")
    val item: Item
) : BaseEntity()

fun aClothingItem(
    price: Long,
    item: Item
) = ClothingItem(
    id = UUID.randomUUID(),
    price = price,
    item = item
)
package com.kaikeventura.sql_nosql.sql.entity.item

import com.kaikeventura.sql_nosql.faker
import com.kaikeventura.sql_nosql.sql.entity.BaseEntity
import com.kaikeventura.sql_nosql.sql.entity.Item
import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToOne
import java.util.*

@Entity(name = "drink_item")
class DrinkItem(
    @Id
    val id: UUID,
    val price: Long,
    val name: String = faker.beer().name(),
    val style: String = faker.beer().style(),

    @OneToOne(cascade = [CascadeType.MERGE], mappedBy = "drinkItem")
    val item: Item
) : BaseEntity()

fun aDrinkItem(
    price: Long,
    item: Item
) = DrinkItem(
    id = UUID.randomUUID(),
    price = price,
    item = item
)

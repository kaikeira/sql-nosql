package com.kaikeventura.sql_nosql.sql.entity.item

import com.kaikeventura.sql_nosql.faker
import com.kaikeventura.sql_nosql.sql.entity.BaseEntity
import com.kaikeventura.sql_nosql.sql.entity.Item
import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToOne
import java.util.*

@Entity(name = "game_item")
class GameItem(
    @Id
    val id: UUID,
    val price: Long,
    val name: String = faker.zelda().game(),

    @OneToOne(cascade = [CascadeType.MERGE], mappedBy = "gameItem")
    val item: Item
) : BaseEntity()

fun aGameItem(
    price: Long,
    item: Item
) = GameItem(
    id = UUID.randomUUID(),
    price = price,
    item = item
)

package com.kaikeventura.sql_nosql.sql.entity.item

import com.kaikeventura.sql_nosql.sql.entity.BaseEntity
import com.kaikeventura.sql_nosql.sql.entity.Item
import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToOne
import java.util.*

@Entity(name = "book_item")
class BookItem(
    @Id
    val id: UUID,
    val price: Long,

    @OneToOne(cascade = [CascadeType.MERGE], mappedBy = "bookItem")
    val item: Item
) : BaseEntity()

fun aBookItem(
    price: Long,
    item: Item
) = BookItem(
        id = UUID.randomUUID(),
        price = price,
        item = item
    )

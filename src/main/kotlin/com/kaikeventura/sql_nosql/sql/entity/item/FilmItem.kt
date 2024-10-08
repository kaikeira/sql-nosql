package com.kaikeventura.sql_nosql.sql.entity.item

import com.kaikeventura.sql_nosql.faker
import com.kaikeventura.sql_nosql.sql.entity.BaseEntity
import com.kaikeventura.sql_nosql.sql.entity.Item
import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToOne
import java.util.*

@Entity(name = "film_item")
class FilmItem(
    @Id
    val id: UUID,
    val price: Long,
    val name: String = faker.internet().domainName(),
    val time: String = faker.internet().uuid(),

    @OneToOne(cascade = [CascadeType.MERGE], mappedBy = "filmItem")
    val item: Item
) : BaseEntity()

fun aFilmItem(
    price: Long,
    item: Item
) = FilmItem(
    id = UUID.randomUUID(),
    price = price,
    item = item
)

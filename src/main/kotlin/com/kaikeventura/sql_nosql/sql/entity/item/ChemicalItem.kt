package com.kaikeventura.sql_nosql.sql.entity.item

import com.kaikeventura.sql_nosql.faker
import com.kaikeventura.sql_nosql.sql.entity.BaseEntity
import com.kaikeventura.sql_nosql.sql.entity.Item
import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToOne
import java.util.*

@Entity(name = "chemical_item")
class ChemicalItem(
    @Id
    val id: UUID,
    val price: Long,
    val name: String = faker.name().name(),

    @OneToOne(cascade = [CascadeType.MERGE], mappedBy = "chemicalItem")
    val item: Item
) : BaseEntity()

fun aChemicalItem(
    price: Long,
    item: Item
) = ChemicalItem(
    id = UUID.randomUUID(),
    price = price,
    item = item
)

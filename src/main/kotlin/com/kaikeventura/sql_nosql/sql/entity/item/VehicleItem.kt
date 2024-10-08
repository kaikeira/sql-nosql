package com.kaikeventura.sql_nosql.sql.entity.item

import com.kaikeventura.sql_nosql.faker
import com.kaikeventura.sql_nosql.sql.entity.BaseEntity
import com.kaikeventura.sql_nosql.sql.entity.Item
import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToOne
import java.util.*

@Entity(name = "vehicle_item")
class VehicleItem(
    @Id
    val id: UUID,
    val price: Long,
    val name: String = faker.funnyName().name(),

    @OneToOne(cascade = [CascadeType.MERGE], mappedBy = "vehicleItem")
    val item: Item
) : BaseEntity()

fun aVehicleItem(
    price: Long,
    item: Item
) = VehicleItem(
    id = UUID.randomUUID(),
    price = price,
    item = item
)
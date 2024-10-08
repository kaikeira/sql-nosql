package com.kaikeventura.sql_nosql.sql.entity

import com.kaikeventura.sql_nosql.sql.entity.item.VehicleItem
import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import java.util.UUID
import kotlin.random.Random

@Entity(name = "fiscal_receipt")
class FiscalReceipt(
    @Id
    val id: UUID,
    val state: String = "OPEN",
    val source: String = "ANYWHERE",
    val target: String = "SOMETHING",
    val amount: Long,
    @OneToMany(cascade = [CascadeType.MERGE], mappedBy = "fiscalReceipt")
    val items: List<Item>? = null
) : BaseEntity()

fun aFiscalReceipt() = FiscalReceipt(id = UUID.randomUUID(), amount = Random.nextLong(1, 999999))

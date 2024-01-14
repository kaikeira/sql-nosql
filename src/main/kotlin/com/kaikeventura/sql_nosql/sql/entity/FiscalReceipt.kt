package com.kaikeventura.sql_nosql.sql.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import java.util.UUID

@Entity(name = "fiscal_receipt")
class FiscalReceipt(
    @Id
    val id: UUID,
    @OneToMany(cascade = [CascadeType.MERGE], mappedBy = "fiscalReceipt")
    val items: List<Item>
) : BaseEntity()

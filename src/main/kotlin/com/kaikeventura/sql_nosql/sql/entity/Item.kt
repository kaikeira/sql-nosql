package com.kaikeventura.sql_nosql.sql.entity

import com.kaikeventura.sql_nosql.sql.entity.item.*
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToOne
import java.util.*

@Entity(name = "item")
class Item(
    @Id
    val id: UUID,

    @ManyToOne
    @JoinColumn(name = "fiscal_receipt_id")
    val fiscalReceipt: FiscalReceipt,

    val price: Long,

    val amount: Int,

    @OneToOne
    @JoinColumn(name = "food_item_id")
    val foodItem: FoodItem? = null,

    @OneToOne
    @JoinColumn(name = "hardware_item_id")
    val hardwareItem: HardwareItem? = null,

    @OneToOne
    @JoinColumn(name = "software_item_id")
    val softwareItem: SoftwareItem? = null,

    @OneToOne
    @JoinColumn(name = "toy_item_id")
    val toyItem: ToyItem? = null,

    @OneToOne
    @JoinColumn(name = "vehicle_item_id")
    val vehicleItem: VehicleItem? = null,

    @OneToOne
    @JoinColumn(name = "chemical_item_id")
    val chemicalItem: ChemicalItem? = null,

    @OneToOne
    @JoinColumn(name = "electronic_item_id")
    val electronicItem: ElectronicItem? = null,

    @OneToOne
    @JoinColumn(name = "clothing_item_id")
    val clothingItem: ClothingItem? = null,

    @OneToOne
    @JoinColumn(name = "drink_item_id")
    val drinkItem: DrinkItem? = null,

    @OneToOne
    @JoinColumn(name = "hygiene_item_id")
    val hygieneItem: HygieneItem? = null,

    @OneToOne
    @JoinColumn(name = "book_item_id")
    val bookItem: BookItem? = null,

    @OneToOne
    @JoinColumn(name = "tool_item_id")
    val toolItem: ToolItem? = null,

    @OneToOne
    @JoinColumn(name = "game_item_id")
    val gameItem: GameItem? = null,

    @OneToOne
    @JoinColumn(name = "film_item_id")
    val filmItem: FilmItem? = null,

    @OneToOne
    @JoinColumn(name = "music_item_id")
    val musicItem: MusicItem? = null,

    @OneToOne
    @JoinColumn(name = "fitness_item_id")
    val fitnessItem: FitnessItem? = null,

) : BaseEntity()

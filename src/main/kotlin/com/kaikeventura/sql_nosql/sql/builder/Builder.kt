package com.kaikeventura.sql_nosql.sql.builder

import com.kaikeventura.sql_nosql.sql.entity.aFiscalReceipt
import com.kaikeventura.sql_nosql.sql.entity.anItem
import com.kaikeventura.sql_nosql.sql.entity.item.BookItem
import com.kaikeventura.sql_nosql.sql.entity.item.ChemicalItem
import com.kaikeventura.sql_nosql.sql.entity.item.aBookItem
import com.kaikeventura.sql_nosql.sql.entity.item.aChemicalItem
import com.kaikeventura.sql_nosql.sql.repository.*
import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Component
import kotlin.random.Random

@Component
class Builder(
    private val fiscalReceiptRepository: FiscalReceiptRepository,
    private val itemRepository: ItemRepository,
    private val foodItemRepository: FoodItemRepository,
    private val hardwareItemRepository: HardwareItemRepository,
    private val softwareItemRepository: SoftwareItemRepository,
    private val toyItemRepository: ToyItemRepository,
    private val vehicleItemRepository: VehicleItemRepository,
    private val chemicalItemRepository: ChemicalItemRepository,
    private val electronicItemRepository: ElectronicItemRepository,
    private val clothingItemRepository: ClothingItemRepository,
    private val drinkItemRepository: DrinkItemRepository,
    private val hygieneItemRepository: HygieneItemRepository,
    private val bookItemRepository: BookItemRepository,
    private val toolItemRepository: ToolItemRepository,
    private val gameItemRepository: GameItemRepository,
    private val filmItemRepository: FilmItemRepository,
    private val musicItemRepository: MusicItemRepository,
    private val fitnessItemRepository: FitnessItemRepository
) {
    @PostConstruct
    fun run() {
        val fiscalReceipt = fiscalReceiptRepository.save(aFiscalReceipt())
        val itemsType = listOf(BookItem::class, ChemicalItem::class)

        itemsType.shuffled().take(10).forEach { itemType ->
            val price = Random.nextLong(1, 999999)
            val amount = Random.nextInt(1, 50)
            val item = itemRepository.save(
                anItem(
                    price = price,
                    amount = amount,
                    fiscalReceipt = fiscalReceipt
                )
            )

            when (itemType) {
                BookItem::class -> {
                    bookItemRepository.save(
                        aBookItem(
                            price = price,
                            item = item
                        )
                    )
                }
                ChemicalItem::class -> {
                    chemicalItemRepository.save(
                        aChemicalItem(
                            price = price,
                            item = item
                        )
                    )
                }
            }
        }
    }
}
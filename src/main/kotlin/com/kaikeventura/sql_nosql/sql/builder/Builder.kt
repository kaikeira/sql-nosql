package com.kaikeventura.sql_nosql.sql.builder

import com.kaikeventura.sql_nosql.sql.entity.aFiscalReceipt
import com.kaikeventura.sql_nosql.sql.entity.anItem
import com.kaikeventura.sql_nosql.sql.entity.item.BookItem
import com.kaikeventura.sql_nosql.sql.entity.item.ChemicalItem
import com.kaikeventura.sql_nosql.sql.entity.item.ClothingItem
import com.kaikeventura.sql_nosql.sql.entity.item.DrinkItem
import com.kaikeventura.sql_nosql.sql.entity.item.ElectronicItem
import com.kaikeventura.sql_nosql.sql.entity.item.FilmItem
import com.kaikeventura.sql_nosql.sql.entity.item.FitnessItem
import com.kaikeventura.sql_nosql.sql.entity.item.FoodItem
import com.kaikeventura.sql_nosql.sql.entity.item.GameItem
import com.kaikeventura.sql_nosql.sql.entity.item.HardwareItem
import com.kaikeventura.sql_nosql.sql.entity.item.HygieneItem
import com.kaikeventura.sql_nosql.sql.entity.item.MusicItem
import com.kaikeventura.sql_nosql.sql.entity.item.SoftwareItem
import com.kaikeventura.sql_nosql.sql.entity.item.ToolItem
import com.kaikeventura.sql_nosql.sql.entity.item.ToyItem
import com.kaikeventura.sql_nosql.sql.entity.item.VehicleItem
import com.kaikeventura.sql_nosql.sql.entity.item.aBookItem
import com.kaikeventura.sql_nosql.sql.entity.item.aChemicalItem
import com.kaikeventura.sql_nosql.sql.entity.item.aClothingItem
import com.kaikeventura.sql_nosql.sql.entity.item.aDrinkItem
import com.kaikeventura.sql_nosql.sql.entity.item.aFilmItem
import com.kaikeventura.sql_nosql.sql.entity.item.aFitnessItem
import com.kaikeventura.sql_nosql.sql.entity.item.aFoodItem
import com.kaikeventura.sql_nosql.sql.entity.item.aGameItem
import com.kaikeventura.sql_nosql.sql.entity.item.aHardwareItem
import com.kaikeventura.sql_nosql.sql.entity.item.aHygieneItem
import com.kaikeventura.sql_nosql.sql.entity.item.aMusicItem
import com.kaikeventura.sql_nosql.sql.entity.item.aSoftwareItem
import com.kaikeventura.sql_nosql.sql.entity.item.aToolItem
import com.kaikeventura.sql_nosql.sql.entity.item.aToyItem
import com.kaikeventura.sql_nosql.sql.entity.item.aVehicleItem
import com.kaikeventura.sql_nosql.sql.entity.item.anElectronicItem
import com.kaikeventura.sql_nosql.sql.repository.*
import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Component
import kotlin.random.Random
import kotlin.reflect.KClass

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

    val itemsType = listOf(
        BookItem::class,
        ChemicalItem::class,
        ClothingItem::class,
        DrinkItem::class,
        ElectronicItem::class,
        FilmItem::class,
        FitnessItem::class,
        FoodItem::class,
        GameItem::class,
        HardwareItem::class,
        HygieneItem::class,
        MusicItem::class,
        SoftwareItem::class,
        ToolItem::class,
        ToyItem::class,
        VehicleItem::class,
    )

    fun createRandomList(size: Int): List<KClass<*>> {
        val shuffledItems = itemsType.shuffled()
        return List(size) { shuffledItems[it % shuffledItems.size] }
    }

    @PostConstruct
    fun run() {
        List(1000000) { 1 }.parallelStream().forEach {
            val fiscalReceipt = fiscalReceiptRepository.save(aFiscalReceipt())
            createRandomList(Random.nextInt(1, 250)).forEach { itemType ->
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
                    ClothingItem::class -> {
                        clothingItemRepository.save(
                            aClothingItem(
                                price = price,
                                item = item
                            )
                        )
                    }
                    DrinkItem::class -> {
                        drinkItemRepository.save(
                            aDrinkItem(
                                price = price,
                                item = item
                            )
                        )
                    }
                    ElectronicItem::class -> {
                        electronicItemRepository.save(
                            anElectronicItem(
                                price = price,
                                item = item
                            )
                        )
                    }
                    FilmItem::class -> {
                        filmItemRepository.save(
                            aFilmItem(
                                price = price,
                                item = item
                            )
                        )
                    }
                    FitnessItem::class -> {
                        fitnessItemRepository.save(
                            aFitnessItem(
                                price = price,
                                item = item
                            )
                        )
                    }
                    FoodItem::class -> {
                        foodItemRepository.save(
                            aFoodItem(
                                price = price,
                                item = item
                            )
                        )
                    }
                    GameItem::class -> {
                        gameItemRepository.save(
                            aGameItem(
                                price = price,
                                item = item
                            )
                        )
                    }
                    HardwareItem::class -> {
                        hardwareItemRepository.save(
                            aHardwareItem(
                                price = price,
                                item = item
                            )
                        )
                    }
                    HygieneItem::class -> {
                        hygieneItemRepository.save(
                            aHygieneItem(
                                price = price,
                                item = item
                            )
                        )
                    }
                    MusicItem::class -> {
                        musicItemRepository.save(
                            aMusicItem(
                                price = price,
                                item = item
                            )
                        )
                    }
                    SoftwareItem::class -> {
                        softwareItemRepository.save(
                            aSoftwareItem(
                                price = price,
                                item = item
                            )
                        )
                    }
                    ToolItem::class -> {
                        toolItemRepository.save(
                            aToolItem(
                                price = price,
                                item = item
                            )
                        )
                    }
                    ToyItem::class -> {
                        toyItemRepository.save(
                            aToyItem(
                                price = price,
                                item = item
                            )
                        )
                    }
                    VehicleItem::class -> {
                        vehicleItemRepository.save(
                            aVehicleItem(
                                price = price,
                                item = item
                            )
                        )
                    }
                }
            }
        }
    }
}

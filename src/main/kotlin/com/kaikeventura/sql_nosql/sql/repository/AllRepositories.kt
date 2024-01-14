package com.kaikeventura.sql_nosql.sql.repository

import com.kaikeventura.sql_nosql.sql.entity.FiscalReceipt
import com.kaikeventura.sql_nosql.sql.entity.Item
import com.kaikeventura.sql_nosql.sql.entity.item.*
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface FiscalReceiptRepository : JpaRepository<FiscalReceipt, UUID>
@Repository
interface ItemRepository : JpaRepository<Item, UUID>
@Repository
interface FoodItemRepository : JpaRepository<FoodItem, UUID>
@Repository
interface HardwareItemRepository : JpaRepository<HardwareItem, UUID>
@Repository
interface SoftwareItemRepository : JpaRepository<SoftwareItem, UUID>
@Repository
interface ToyItemRepository : JpaRepository<ToyItem, UUID>
@Repository
interface VehicleItemRepository : JpaRepository<VehicleItem, UUID>
@Repository
interface ChemicalItemRepository : JpaRepository<ChemicalItem, UUID>
@Repository
interface ElectronicItemRepository : JpaRepository<ElectronicItem, UUID>
@Repository
interface ClothingItemRepository : JpaRepository<ClothingItem, UUID>
@Repository
interface DrinkItemRepository : JpaRepository<DrinkItem, UUID>
@Repository
interface HygieneItemRepository : JpaRepository<HygieneItem, UUID>
@Repository
interface BookItemRepository : JpaRepository<BookItem, UUID>
@Repository
interface ToolItemRepository : JpaRepository<ToolItem, UUID>
@Repository
interface GameItemRepository : JpaRepository<GameItem, UUID>
@Repository
interface FilmItemRepository : JpaRepository<FilmItem, UUID>
@Repository
interface MusicItemRepository : JpaRepository<MusicItem, UUID>
@Repository
interface FitnessItemRepository : JpaRepository<FitnessItem, UUID>

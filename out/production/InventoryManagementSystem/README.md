## Table of Contents
- [Features](#features) 
- [Installation](#installation)
- [Summarise](#Summarise)
- [Contributing](#contributing)
- [License](#license)

## features
- Handle multiple products, track stock levels, process orders and ensure timely replenishment.
- System should accommodate different product types, handle various inventory operations and accurate report.
- Efficiently notifies when stock levels are low


## Opeartions
- Manager can add new products to the inventory
- Stock level are updated when products are received or shipped.
- Replenishment based on various strategy.
- Efficiently notifies when stocks are low.

## Summarise
- System to handle mulitple product categories, accross various warehouses or section of wareshouse
- Various opertions - Add, update
- Stock level tracking and management
- Strategical replenishment


## Key Components
- Product (pid, name/description, price, threshold, quantity, category)
- Warehouse ( wid, address, map<pid, product>)
- InventoryManager (List<wareshouse>, some important function 
-  ProductFactory, InventoryObserers, ReplenishmentStrategy).

## Product
- Product will be abstract class and other product category will extend it. 
- Child classes can have their local feilds for finer control
- We will utilise Factory Design pattern to create new Product, and it will based on product category.

## Replenishment 
- Use strategy design pattern for replenishment
- usecases : Grocery - based on shelf lief.
             Electronics - ony when when stock falls below threshold.
             FestiveStrategy-
- High demand items may use ML based predictive restocking during peak seaons.

## InventoryManager 
- Utilise singleton design pattern for this.
- It will be accessed globally across, and we should not create many instances.
- Inventory operations often involve concurrency ( eg simultaneous orders, udpates)
  it will help in coordinating locks, and prevent race conditions, using synchronized stock udpates and so on.
- It will act as central point of access, central source of truth.


## Observer Design pattern 
- For sending notificatino to various stakeholder. 
- check once we remove items.
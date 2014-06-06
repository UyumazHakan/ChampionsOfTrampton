ChampionsOfTrampton
===================

CS434 - Advanced Object Oriented Course Project

Multiplayer, turn-based assasination strategy game. It is writtten in Java and under heavy development.

The main class is in Main.java which is located in src. 

For now, each player can control their own character and travel across randomly generated rooms. The aim of each character is finding their targets and kill them before their murderer kill him/her. 

Features To Add
-------------

Network

Health Conditions

Unique Class Abilities

Weapons

Patterns Used
--------------

MVC - All programming design based on MVC.

Command - Each action in game is made by command pattern. This will make network easier to implement in future.

Factory - Maps are randomly created with map factory. In future, there could be other game modes and they have other kinds of maps. To creating these different maps factory pattern is important.

Decorator (in part that not yet implemented) - In design of health conditions of characters decorator pattern is used. With this, characters can have more than one health condition and each of them can effect player equally.

Strategy (in part that not yet implemented) - Weapons have different kinds of behaviors. This lets programmer more flexible area for weapons in future. Swapping weapon or dropping weapon mechanisms are much more easy to implement. 

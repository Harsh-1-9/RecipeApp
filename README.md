# 🍳 Recipe App

A recipe browsing app built with **Kotlin** and **Jetpack Compose**, using live data from the [DummyJSON Recipes API](https://dummyjson.com/docs/recipes).

## Features

- 📋 Browse a list of recipes fetched live from the DummyJSON API
- 🍜 Filter recipes by cuisine
- 📖 Tap into a detailed recipe view — ingredients, step-by-step instructions, prep time, cook time, servings, and calories
- ⬅️ Smooth navigation between the recipe list and detail screens

## Tech Stack

- **Kotlin** + **Jetpack Compose** — UI
- **Ktor Client** — networking
- **kotlinx.serialization** — JSON parsing
- **Coil** — image loading
- **Navigation Compose** (type-safe routes) — screen navigation
- **MVVM + Repository Pattern** — architecture

## Architecture

```
UI (Compose Screens) → ViewModel → Repository (interface) → Repository Implementation → API Service → Ktor Client → API
```

## What I learned

This project was built while learning Android development, starting from a YouTube tutorial (Neat Roots) and then going deeper on my own — breaking down every file to understand *why* it exists, how the layers (Data → Repository → ViewModel → UI) connect, and how a real Android app is structured end to end, rather than just copying code.

## Credits

Recipe data provided by the free [DummyJSON](https://dummyjson.com/) API.

## Getting Started

1. Clone the repo
2. Open in Android Studio
3. Sync Gradle and run on an emulator or device

---

More updates coming soon as I keep building on this project. Feedback welcome!

# 🟢 GENERAL ALI's ARMY (Easy)

## 📌 Problem Statement

General Ali has initiated an invasion in the shape of an **N × M grid** behind enemy lines given by a 2D array `Q`.

The grid consists of cells represented by the following characters:

- `'*'` → Block cell that cannot be visited  
- `'A'` → Cell already invaded by General Ali’s army  
- `'E'` → Cell containing the enemy’s army  

---

## ⏳ Invasion Rule

At each second:

Any cell marked `'E'` that shares a side (up, down, left, right) with a cell marked `'A'` becomes invaded (`'A'`).

---

## 🎯 Task

Find the **minimum time** required to invade all enemy cells (`'E'`).

If it is **not possible**, return **-1**.

---

## 📥 Input Format

1. First line → Integer `N` (number of rows)  
2. Second line → Integer `M` (number of columns)  
3. Next `N` lines → Each line contains a string representing row `Q[i]`

---

## 📌 Constraints

- `1 ≤ N ≤ 10³`
- `1 ≤ M ≤ 10³`
- `1 ≤ len(Q[i]) ≤ 10⁵`

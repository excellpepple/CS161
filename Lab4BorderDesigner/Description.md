# CS161 Introduction to Computer Science II - Spring 2025

## Lab 4
**Due Date:** February 16 at 11:59 P.M.  
**Total Points:** 30

---

## Goals
By completing this lab, you will gain further experience with:
- Layout containers
- GUI controls
- Formatting/styling
- Event-driven programming

**Project Naming Convention:** Name your Eclipse project **Lab4FirstNameLastName**.

---

## Requirements
### (20 pts) GUI Design & Implementation
Design and implement a GUI that changes the **Label background color** based on the color selected by the user. Refer to **Figure 1** for GUI structure.

### **Key Features:**
- Create a class **ColorSelectionGUI**.
- The GUI consists of **Labels, RadioButtons, and CheckBoxes**.
- The application includes four **Labels** positioned around the perimeter of the window:
  - "North", "South", "East", and "West".
  - The text on each Label should be **center-aligned**.
- All four CheckBoxes should be **initially selected**, indicating that their corresponding Labels will be recolored.
- Set the initial background color of the four Labels to **cyan**.
  - Alternatively, trigger the **Cyan** RadioButton’s click event manually (see **Hints** section).
- The text color of each **RadioButton** should match its associated color (see **Hints** section).
- The **Cyan** RadioButton should be **initially selected**.
- **RadioButtons should function as a group** (only one selection at a time).

#### **Figure 1: Initial GUI Before User Interaction**
*(Example layout to be referenced in implementation.)*

---

## (10 pts) Event Handling
Implement an **event-handling class** that responds to user interactions.

### **Behavior:**
- When a **RadioButton** is clicked, update the background color of all **Labels** corresponding to the selected CheckBoxes.
- Only **one event handler** should be written and assigned to all **RadioButtons**.

### **Example Cases:**
- **Case 1:** User selects the "Spring Green" RadioButton with all CheckBoxes selected:
  - **Figure 2: Labels change to Spring Green**
- **Case 2:** User deselects "North" and "East" CheckBoxes and clicks "Salmon" RadioButton:
  - **Figure 3: Only South and West Labels change to Salmon**
- **Case 3:** User selects only "East" CheckBox and clicks "Orange" RadioButton:
  - **Figure 4: Only East Label changes to Orange**

---

## Hints
- To match the example GUI’s **spacing and formatting**, use these properties:
  - **All sections:** `Alignment: Pos.CENTER`
  - **Center section:**
    - Preferred size: `220 width, 160 height`
    - Horizontal gap: `15`
    - Vertical gap: `4`
  - **North and South Labels:**
    - Preferred size: `primaryStage.getWidth(), 40 height`
    - Must be set **after** `primaryStage.show()` to get the correct width.
  - **East and West Labels:**
    - Preferred size: `40 width, primaryStage.getHeight() – 80 height`
    - Must be set **after** `primaryStage.show()`.

### **Pre-setting the Background Color**
If you prefer not to set the **background color manually** for each Label at the start, trigger the **Cyan** RadioButton’s event manually:
```java
cyanRdo.fireEvent(new ActionEvent());

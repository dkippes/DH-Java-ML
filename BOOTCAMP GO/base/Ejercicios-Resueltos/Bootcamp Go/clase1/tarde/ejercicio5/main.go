package main

import (
	"fmt"
)

func main() {

	var estudiantes = []string{"Benjamin", "Nahuel", "Brenda", "Marcos",
		"Pedro", "Axel", "Alez", "Dolores", "Federico",
		"Hernan", "Leandro", "Eduardo", "Duvraschka"}

	estudiantes = append(estudiantes, "Vincent")

	fmt.Println(estudiantes)

}

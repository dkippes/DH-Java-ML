package main

import (
	"fmt"
)

func main() {

	var precio int = 4000
	var porcentaje int = 15

	descuento := (precio / 100) * porcentaje

	resultado := precio - descuento

	fmt.Println("Precio del producto:", precio, "$")
	fmt.Println("Descuento del", porcentaje, "%", "aplicado al producto:", descuento, "$")
	fmt.Println("Monto a pagar:", resultado, "$")

}

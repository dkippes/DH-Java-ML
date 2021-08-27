package main

import "fmt"

type productos struct {
	dimension    int32
	tipoProducto string
}

func main() {
	var sEnvios []productos
	var disponibilidadEnvios int32
	condicionEspecial := false
	producto1 := productos{tipoProducto: "chico", dimension: 500000}
	producto2 := productos{tipoProducto: "mediano", dimension: 1000000}
	producto3 := productos{tipoProducto: "grande", dimension: 1500000}
	producto4 := productos{tipoProducto: "fragil", dimension: 400000}
	producto5 := productos{tipoProducto: "especial", dimension: 250000}
	totalDimension, tipoProducto := Envio(producto1.tipoProducto, producto1.dimension)
	sEnvios, disponibilidadEnvios = AgregarProducto(tipoProducto, totalDimension, 10000000, sEnvios)
	totalDimension, tipoProducto = Envio(producto2.tipoProducto, producto2.dimension)
	sEnvios, disponibilidadEnvios = AgregarProducto(tipoProducto, totalDimension, disponibilidadEnvios, sEnvios)
	totalDimension, tipoProducto = Envio(producto3.tipoProducto, producto3.dimension)
	sEnvios, disponibilidadEnvios = AgregarProducto(tipoProducto, totalDimension, disponibilidadEnvios, sEnvios)
	totalDimension, tipoProducto = Envio(producto4.tipoProducto, producto4.dimension)
	sEnvios, disponibilidadEnvios = AgregarProducto(tipoProducto, totalDimension, disponibilidadEnvios, sEnvios)
	for _, envio := range sEnvios {
		if envio.tipoProducto != "especial" {
			condicionEspecial = true
		}
	}
	if condicionEspecial != true {
		totalDimension, tipoProducto = Envio(producto5.tipoProducto, producto5.dimension)
		sEnvios, disponibilidadEnvios = AgregarProducto(tipoProducto, totalDimension, disponibilidadEnvios, sEnvios)
	} else {
		fmt.Println("Hay productos no especiales en el envio.")
	}
	fmt.Println("Pedidos cargados: ", sEnvios)
	fmt.Println("Disponibilidad restante ", disponibilidadEnvios)
}
func AgregarProducto(tipoProducto string, dimension int32, disponibilidadEnvios int32, productoSlice []productos) ([]productos, int32) {
	if disponibilidadEnvios > 0 {
		disponibilidadEnvios = disponibilidadEnvios - dimension
		productoSlice = append(productoSlice, productos{tipoProducto: tipoProducto, dimension: dimension})
	}
	return productoSlice, disponibilidadEnvios
}
func Envio(tipoProducto string, dimension int32) (int32, string) {
	switch tipoProducto {
	case "chico":
		return dimension, tipoProducto
	case "mediano":
		var porcentaje int32
		porcentaje = (dimension + 5) / 100
		return dimension + porcentaje, tipoProducto
	case "grande":
		var porcentaje int32
		porcentaje = (dimension * 20) / 100
		return dimension + porcentaje, tipoProducto
	case "fragil":
		var porcentaje int32
		porcentaje = (dimension * 75) / 100
		return dimension + porcentaje, tipoProducto
	case "especial":
		return dimension, tipoProducto
	}
	return 0, ""
}

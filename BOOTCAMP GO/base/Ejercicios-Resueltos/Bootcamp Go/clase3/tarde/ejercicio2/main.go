package main

import "fmt"

type Usuario struct {
	nombre    string
	apellido  string
	correo    string
	productos []*Producto
}

type Producto struct {
	nombre   string
	precio   float64
	cantidad uint
}

func nuevoProducto(nombre string, precio float64) *Producto {
	return &Producto{nombre: nombre, precio: precio}
}

func agregarProducto(usu *Usuario, pro *Producto, cantidad uint) {
	pro.cantidad = cantidad
	usu.productos = append(usu.productos, pro)
}

func main() {

	u := &Usuario{
		nombre:   "Vincet",
		apellido: "Conace",
		correo:   "FFDSFs",
	}

	producto := nuevoProducto("martillo", 124.34)
	agregarProducto(u, producto, 10)
	fmt.Println(u.nombre, u.apellido, u.correo)
	for _, valor := range u.productos {
		fmt.Println(*valor)
	}

}

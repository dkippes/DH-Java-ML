package main

import f "fmt"

type producto struct {
	nombre   string
	precio   float64
	cantidad int
}

type servicio struct {
	nombre            string
	precio            float64
	minutosTrabajados int
}

type mantenimineto struct {
	nombre string
	precio float64
}

func SumarProductos(p []producto, c chan float64) {
	var suma float64
	for _, valor := range p {
		precio := valor.precio * float64(valor.cantidad)
		suma += precio
	}
	c <- suma
}

func SumarServicios(s []servicio, c chan float64) {
	var suma float64
	for _, valor := range s {
		precio := valor.precio * float64(valor.minutosTrabajados)
		suma += precio
	}
	c <- suma
}

func SumarMantenimientos(m []mantenimineto, c chan float64) {
	var suma float64
	for _, valor := range m {
		suma += valor.precio
	}
	c <- suma
}

func main() {
	productos := []producto{{"Martillo", 123.3, 5}, {"Camara", 234.43, 5}}
	servicios := []servicio{{"Sprint Website", 200, 30}, {"Envio de paqetes", 20, 30}}
	manteniminetos := []mantenimineto{{"Aires acondicionados", 2000}, {"Cortar pasto", 1500}}

	channel1 := make(chan float64)
	channel2 := make(chan float64)
	channel3 := make(chan float64)
	go SumarProductos(productos, channel1)
	go SumarServicios(servicios, channel2)
	go SumarMantenimientos(manteniminetos, channel3)

	//f.Println("Precio total de los productos:", <-channel1)
	//f.Println("Precio total de los servicios:", <-channel2)
	//f.Println("Precio total de los mantenimientos:", <-channel3)

	sumaTotal := <-channel1 + <-channel2 + <-channel3
	f.Println("Suma de todos los precios es: ", sumaTotal)
}

-- Dump simplificado y optimizado de la base de datos supermercado

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";
START TRANSACTION;

-- Creación de tablas
CREATE TABLE IF NOT EXISTS `usuarios` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombreUsuario` varchar(50) NOT NULL,
  `contrasena` varchar(200) NOT NULL,
  `tipo` enum('Administrador','Cajero') NOT NULL DEFAULT 'Cajero',
  PRIMARY KEY (`idUsuario`),
  UNIQUE KEY `nombreUsuario` (`nombreUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

CREATE TABLE IF NOT EXISTS `productos` (
  `idProducto` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `precio` double NOT NULL,
  `categoria` enum('SinCategoria','Limpieza','Alimentacion','Bebidas','Panaderia','Carniceria','Pescaderia','Congelados','Lacteos','FrutasVerduras','HigienePersonal','CuidadoBebe','Perfumeria','Mascotas','Drogueria','Papeleria','Electrodomesticos','Ropa','Ferreteria','Jugueteria','Tecnologia') DEFAULT 'SinCategoria',
  `marca` enum('SinMarca','Nestle','CocaCola','Pepsi','Danone','Loreal','Nike','Adidas','Samsung','Apple','Sony','Unilever','Lego','Henkel','Oralb','Philips','Bosch','Zara','Ikea','Honda') DEFAULT 'SinMarca',
  `unidades` int(11) NOT NULL DEFAULT 0,
  `enVenta` tinyint(1) DEFAULT 1,
  `fechaCaducidad` date DEFAULT NULL,
  PRIMARY KEY (`idProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

CREATE TABLE IF NOT EXISTS `facturas` (
  `idFactura` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` datetime DEFAULT CURRENT_TIMESTAMP,
  `usuarioResponsable` int(11) NOT NULL,
  `total` double NOT NULL,
  `efectivo` double NOT NULL,
  `cambio` double NOT NULL,
  PRIMARY KEY (`idFactura`),
  KEY `usuarioResponsable` (`usuarioResponsable`),
  CONSTRAINT `facturas_ibfk_1` FOREIGN KEY (`usuarioResponsable`) REFERENCES `usuarios` (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

CREATE TABLE IF NOT EXISTS `factura_detalles` (
  `idDetalle` int(11) NOT NULL AUTO_INCREMENT,
  `idFactura` int(11) NOT NULL,
  `idProducto` int(11) NOT NULL,
  `nombreProducto` varchar(100) NOT NULL,
  `precioUnitario` double NOT NULL,
  `cantidad` int(11) NOT NULL,
  `subtotal` double NOT NULL,
  PRIMARY KEY (`idDetalle`),
  KEY `idFactura` (`idFactura`),
  KEY `idProducto` (`idProducto`),
  CONSTRAINT `factura_detalles_ibfk_1` FOREIGN KEY (`idFactura`) REFERENCES `facturas` (`idFactura`) ON DELETE CASCADE,
  CONSTRAINT `factura_detalles_ibfk_2` FOREIGN KEY (`idProducto`) REFERENCES `productos` (`idProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- Inserción de datos en tablas
INSERT INTO `usuarios` (`idUsuario`, `nombreUsuario`, `contrasena`, `tipo`) VALUES
(1, 'admin', '8Ob2XvduFmzvi/MCYZyTPw==', 'Administrador'),
(2, 'usuario', 'gcbqo3tkOtsWaV7DGYVtsw==', 'Cajero'),
(3, 'cajero1', 'aZqj9fQoYcaM9p8VyWf8Kg==', 'Cajero'),
(4, 'ddd', 'wAkPL4/P/iLQzszoWxBWPA==', 'Administrador'),
(5, 'cajero3', 'U360o9P4LTt0lZySls++kQ==', 'Cajero'),
(6, 'test50', 'CmlgauQlOIz+rjJ65bnV3A==', 'Cajero');

INSERT INTO `productos` (`idProducto`, `nombre`, `precio`, `categoria`, `marca`, `unidades`, `enVenta`, `fechaCaducidad`) VALUES
(1, 'Leche Entera', 0.95, 'Lacteos', 'SinMarca', 0, 1, '2025-12-31'),
(2, 'Pan de molde', 1.25, 'Panaderia', 'SinMarca', 398, 1, '2025-11-15'),
(3, 'Coca Cola lata', 0.8, 'Bebidas', 'CocaCola', 79, 1, '2026-01-01'),
(4, 'Detergente líquido', 3.95, 'Limpieza', 'Unilever', 190, 1, '2026-06-01'),
(5, 'Manzanas', 2.2, 'FrutasVerduras', 'SinMarca', 16, 1, '2025-06-30'),
(7, 'Coca Cola lata', 0.81, 'Bebidas', 'CocaCola', 100, 1, '2026-01-01');

INSERT INTO `factura_detalles` (`idDetalle`, `idFactura`, `idProducto`, `nombreProducto`, `precioUnitario`, `cantidad`, `subtotal`) VALUES
(1, 2, 1, 'Leche Entera', 0.95, 4, 3.8),
(2, 3, 1, 'Leche Entera', 0.95, 35, 33.25),
(3, 4, 1, 'Leche Entera', 0.95, 3, 2.85),
(4, 11, 5, 'Manzanas', 2.2, 3, 6.6),
(5, 11, 2, 'Pan de molde', 1.25, 1, 1.25),
(6, 12, 2, 'Pan de molde', 1.25, 3, 3.75),
(7, 13, 2, 'Pan de molde', 1.25, 5, 6.25),
(8, 14, 1, 'Leche Entera', 0.95, 60, 57),
(9, 14, 3, 'Coca Cola lata', 0.8, 40, 32),
(10, 15, 3, 'Coca Cola lata', 0.8, 5, 4),
(11, 16, 3, 'Coca Cola lata', 0.8, 95, 76),
(12, 17, 4, 'Detergente líquido', 3.95, 1, 3.95);

COMMIT;

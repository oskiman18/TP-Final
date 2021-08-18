CREATE PROCEDURE `SP_Report()` ()
BEGIN
Select count(DNI) as 'Usuarios Activos', 
(select count(dni) where estado = 0) as 'Usuario Inactivos',
(select count(id) from movimientos) as 'transferencias',
(select SUM(saldo) from cuenta) as 'Saldo Total',
(select count(ncuenta)from cuenta) as 'Cuentas Totales',
(select count(tipo) from Cuenta where tipo=1) as 'Cuentas Corrientes',
(select count(tipo) from Cuenta where tipo=0) as 'Cajas de Ahorro' ,
(select avg(importe) from movimientos) as 'Monto Promedio Transferencia'
from usuarios as u where estado =1
END

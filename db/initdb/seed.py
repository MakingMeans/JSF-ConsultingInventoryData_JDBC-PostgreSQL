import psycopg2
from faker import Faker
import random
from datetime import datetime, timedelta

fake = Faker('es_CO')

# Conexión a la base de datos
conn = psycopg2.connect(
    dbname="rendimiento_sophyfarm_db",
    user="admin",
    password="admin123",
    host="localhost",
    port="5433"
)
cur = conn.cursor()

# =============================================
# Limpieza controlada de datos
# =============================================
print("Limpiando tablas (sin borrar categorías ni unidades)...")
cur.execute("DELETE FROM factura_detalle;")
cur.execute("DELETE FROM factura;")
cur.execute("DELETE FROM elemento;")
conn.commit()
print("Limpieza completada.\n")

# =============================================
# Insertar 70,000 elementos
# =============================================
print("Insertando 70,000 elementos...")
for i in range(1, 70001):
    precio_actual = round(random.uniform(1000, 50000), 2)
    precio_anterior = round(precio_actual * random.uniform(0.8, 1.2), 2)
    costo = round(precio_actual * random.uniform(0.6, 0.9), 2)
    margen = round(precio_actual - costo, 2)

    cur.execute("""
        INSERT INTO elemento (
            id, sku_elemnto, nmbre_elemnto, lote_elemnto, ctgria_elemnto,
            und_elemnto, exstncia_elemnto, prsntacion_elemnto, lbrtorio_elemnto,
            cntrolado_elemnto, bdga_elemnto, precio_venta_ac, precio_venta_an,
            costo_venta, mrgen_utldad, tiene_iva, stock_minimo, stock_maximo, estdo_elmnto
        ) VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
    """, (
        i,
        f"SKU-{i:06d}",
        f"NOMPROD-{i:06d}",
        f"LOTE-{random.randint(1000,9999)}",
        random.randint(1, 3),      # categoría existente (1–3)
        random.randint(1, 3),      # unidad existente (1–3)
        random.randint(10, 500),
        fake.word().capitalize(),
        fake.company().split(" ")[0],
        random.choice(['S', 'N']),
        random.randint(1, 10),
        precio_actual,
        precio_anterior,
        costo,
        margen,
        random.choice(['S', 'N']),
        random.randint(5, 20),
        random.randint(50, 200),
        random.choice(['A', 'I'])
    ))

conn.commit()
print("Elementos insertados correctamente.\n")

# =============================================
# Insertar 100 facturas
# =============================================
print("Insertando 100 facturas...")
for i in range(1, 101):
    fecha = datetime.now() - timedelta(days=random.randint(0, 365))
    bruto = random.randint(10000, 200000)
    dscto = random.randint(0, int(bruto * 0.1))
    impuesto = int((bruto - dscto) * 0.19)
    neto = bruto - dscto + impuesto

    cur.execute("""
        INSERT INTO factura (
            id_cliente, id_tpo_fctura, fcha_fctura, vlor_brto, vlor_dscto,
            vlor_impsto, vlor_nto, sldo_fctura, estdo_fctura
        ) VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s)
    """, (
        100 + i,
        1,
        fecha,
        bruto,
        dscto,
        impuesto,
        neto,
        0,
        random.choice(['P', 'A'])
    ))

conn.commit()
print("Facturas insertadas correctamente.\n")

# =============================================
# Insertar detalles de factura
# =============================================
print("Insertando detalles de facturas...")
detalle_id = 1
for factura_id in range(1, 101):
    for _ in range(random.randint(3, 8)):  # 3–8 productos por factura
        producto_id = random.randint(1, 70000)
        cantidad = random.randint(1, 10)
        precio_unitario = round(random.uniform(1000, 50000), 2)
        vlr_dscto = round(precio_unitario * random.uniform(0.0, 0.1), 2)
        vlr_impsto = round((precio_unitario - vlr_dscto) * 0.19, 2)

        cur.execute("""
            INSERT INTO factura_detalle (
                id, id_factura, id_elemnto, cntdad_elemnto,
                prcio_untrio, vlr_dscto, vlr_impsto
            ) VALUES (%s, %s, %s, %s, %s, %s, %s)
        """, (
            detalle_id,
            factura_id,
            producto_id,
            cantidad,
            precio_unitario,
            vlr_dscto,
            vlr_impsto
        ))
        detalle_id += 1

conn.commit()
print("Detalles de facturas insertados correctamente.\n")

# =============================================
# Cierre
# =============================================
cur.close()
conn.close()
print("Base de datos generada exitosamente con:")
print("   • 3 categorías preexistentes")
print("   • 3 unidades preexistentes")
print("   • 70,000 elementos")
print("   • 100 facturas")
print("   • ~500 detalles de factura\n")

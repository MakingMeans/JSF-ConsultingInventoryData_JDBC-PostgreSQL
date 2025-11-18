-- ===============================================
-- CREACIÓN DE TABLAS
-- ===============================================

CREATE TABLE categoria_producto (
    id SERIAL PRIMARY KEY,
    estdo_ctgria CHAR(1),
    nmbre_ctgria VARCHAR(255)
);

CREATE TABLE unidad (
    id SERIAL PRIMARY KEY,
    nmbre_undad VARCHAR(20) NOT NULL,
    estdo_undad VARCHAR(1) NOT NULL
);

CREATE TABLE elemento (
    id SERIAL PRIMARY KEY,
    sku_elemnto VARCHAR(255),
    nmbre_elemnto VARCHAR(255),
    lote_elemnto VARCHAR(255),
    ctgria_elemnto SMALLINT NOT NULL,
    und_elemnto SMALLINT NOT NULL,
    exstncia_elemnto INT NOT NULL,
    prsntacion_elemnto VARCHAR(80) NOT NULL,
    lbrtorio_elemnto VARCHAR(60) NOT NULL,
    cntrolado_elemnto VARCHAR(1) NOT NULL,
    bdga_elemnto INT NOT NULL,
    precio_venta_ac DOUBLE PRECISION NOT NULL,
    precio_venta_an DOUBLE PRECISION NOT NULL,
    costo_venta DOUBLE PRECISION NOT NULL,
    mrgen_utldad DOUBLE PRECISION NOT NULL,
    tiene_iva VARCHAR(1) NOT NULL,
    stock_minimo INT NOT NULL,
    stock_maximo INT NOT NULL,
    estdo_elmnto VARCHAR(1) NOT NULL,
    CONSTRAINT fk_elemento_categoria FOREIGN KEY (ctgria_elemnto) REFERENCES categoria_producto (id),
    CONSTRAINT fk_unidad FOREIGN KEY (und_elemnto) REFERENCES unidad (id)
);

CREATE TABLE factura (
    id SERIAL PRIMARY KEY,
    id_cliente SMALLINT NOT NULL,
    id_tpo_fctura SMALLINT NOT NULL,
    fcha_fctura TIMESTAMP NOT NULL,
    vlor_brto INT,
    vlor_dscto INT,
    vlor_impsto INT,
    vlor_nto INT,
    sldo_fctura INT,
    estdo_fctura VARCHAR(1) NOT NULL
);

CREATE TABLE factura_detalle (
    id SERIAL PRIMARY KEY,
    id_factura SMALLINT NOT NULL,
    id_elemnto INT NOT NULL,
    cntdad_elemnto INT NOT NULL,
    prcio_untrio DECIMAL NOT NULL,
    vlr_dscto DECIMAL NOT NULL,
    vlr_impsto DECIMAL NOT NULL,
    CONSTRAINT fk_factura FOREIGN KEY (id_factura) REFERENCES factura (id),
    CONSTRAINT fk_elemnto FOREIGN KEY (id_elemnto) REFERENCES elemento (id)
);

-- ===============================================
-- INSERCIÓN DE DATOS
-- ===============================================

INSERT INTO categoria_producto (estdo_ctgria, nmbre_ctgria) VALUES
    ('A', 'Medicamentos'),
    ('A', 'Suplementos'),
    ('A', 'Cuidado personal');

INSERT INTO unidad (nmbre_undad, estdo_undad) VALUES
    ('Unidad', 'A'),
    ('Caja', 'A'),
    ('Frasco', 'A');


-- ===============================================
-- OPTIMIZACIÓN (ÍNDICES)
-- ===============================================
CREATE EXTENSION IF NOT EXISTS pg_trgm;
CREATE EXTENSION IF NOT EXISTS btree_gin;

CREATE INDEX IF NOT EXISTS idx_elemento_nombre_trgm
    ON elemento USING gin (nmbre_elemnto gin_trgm_ops);

CREATE INDEX IF NOT EXISTS idx_elemento_sku_trgm
    ON elemento USING gin (sku_elemnto gin_trgm_ops);

CREATE INDEX IF NOT EXISTS idx_elemento_categoria
    ON elemento (ctgria_elemnto);

CREATE INDEX IF NOT EXISTS idx_elemento_unidad
    ON elemento (und_elemnto);

CREATE INDEX IF NOT EXISTS idx_elemento_precio
    ON elemento (precio_venta_ac);

CREATE INDEX IF NOT EXISTS idx_elemento_categoria_precio
    ON elemento (ctgria_elemnto, precio_venta_ac);

CREATE INDEX IF NOT EXISTS idx_factura_detalle_factura
    ON factura_detalle (id_factura);

CREATE INDEX IF NOT EXISTS idx_factura_detalle_elemento
    ON factura_detalle (id_elemnto);

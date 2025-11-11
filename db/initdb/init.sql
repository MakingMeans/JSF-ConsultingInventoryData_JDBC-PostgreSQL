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

/*INSERT INTO elemento (
    sku_elemnto, nmbre_elemnto, lote_elemnto, ctgria_elemnto, und_elemnto,
    exstncia_elemnto, prsntacion_elemnto, lbrtorio_elemnto,
    cntrolado_elemnto, bdga_elemnto, precio_venta_ac, precio_venta_an,
    costo_venta, mrgen_utldad, tiene_iva, stock_minimo, stock_maximo, estdo_elmnto
) VALUES
      ('PROD001', 'Paracetamol 500mg', 'L001', 1, 1, 120, 'Blíster 10 tabletas', 'Genfar', 'N', 1, 1500, 1400, 900, 600, 'S', 50, 500, 'A'),
      ('PROD002', 'Vitamina C 1000mg', 'L002', 2, 2, 80, 'Caja 20 tabletas', 'MK', 'N', 1, 3500, 3300, 2200, 1300, 'S', 20, 300, 'A'),
      ('PROD003', 'Crema hidratante 200ml', 'L003', 3, 3, 40, 'Frasco 200ml', 'Nivea', 'N', 1, 12000, 11500, 8000, 4000, 'S', 10, 100, 'A'),
      ('PROD004', 'Ibuprofeno 400mg', 'L004', 1, 1, 200, 'Blíster 10 tabletas', 'Tecnoquímicas', 'S', 1, 1800, 1700, 1000, 800, 'S', 50, 500, 'A');

INSERT INTO factura (
    id_cliente, id_tpo_fctura, fcha_fctura, vlor_brto, vlor_dscto,
    vlor_impsto, vlor_nto, sldo_fctura, estdo_fctura
) VALUES
      (101, 1, '2025-01-15 10:30:00', 18000, 1000, 2700, 19700, 0, 'P'),
      (102, 1, '2025-02-10 14:00:00', 8000, 0, 1200, 9200, 0, 'P'),
      (103, 1, '2025-03-22 11:45:00', 24000, 2000, 3600, 25600, 0, 'P'),
      (104, 1, '2025-03-28 16:20:00', 9000, 0, 1350, 10350, 0, 'P'),
      (105, 1, '2025-04-05 13:10:00', 32000, 1500, 4800, 35300, 0, 'P');

INSERT INTO factura_detalle (
    id_factura, id_elemnto, cntdad_elemnto, prcio_untrio, vlr_dscto, vlr_impsto
) VALUES
      (1, 1, 5, 1500, 500, 2250),
      (1, 2, 2, 3500, 500, 700),
      (2, 1, 3, 1500, 0, 675),
      (2, 4, 1, 1800, 0, 270),
      (3, 3, 1, 12000, 1000, 1800),
      (3, 1, 6, 1500, 1000, 1350),
      (4, 2, 3, 3500, 0, 1050),
      (4, 4, 2, 1800, 0, 540),
      (5, 1, 10, 1500, 1500, 3000),
      (5, 3, 2, 12000, 0, 3600);*/

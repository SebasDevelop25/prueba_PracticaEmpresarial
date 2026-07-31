CREATE TABLE IF NOT EXISTS productos (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre TEXT NOT NULL,
    precio REAL NOT NULL,
    stock INTEGER NOT NULL DEFAULT 0,
    categoria TEXT NOT NULL
)

INSERT INTO productos (nombre, precio, stock, categoria) VALUES
('Teclado mecanico', 100000, 10, 'Electronics'),
('Mouse inalambrico', 50000, 25, 'Electronics'),

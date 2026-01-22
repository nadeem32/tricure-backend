-- liquibase formatted sql

-- changeset tricure:4
ALTER TABLE product ADD COLUMN image_url VARCHAR(500);
ALTER TABLE customer ADD COLUMN logo_url VARCHAR(500);

-- Update existing products with default images
UPDATE product SET image_url = 'https://images.unsplash.com/photo-1576091160399-112ba8d25d1d?ixlib=rb-4.0.3&auto=format&fit=crop&w=800&q=80' WHERE name = 'LIS Pro';
UPDATE product SET image_url = 'https://images.unsplash.com/photo-1581091226825-a6a2a5aee158?ixlib=rb-4.0.3&auto=format&fit=crop&w=800&q=80' WHERE name = 'Analyzer Connect';
UPDATE product SET image_url = 'https://images.unsplash.com/photo-1518770660439-4636190af475?ixlib=rb-4.0.3&auto=format&fit=crop&w=800&q=80' WHERE image_url IS NULL;

-- Update existing customers with default logos (using placeholders)
UPDATE customer SET logo_url = 'https://ui-avatars.com/api/?name=City+Hospital&background=0D8ABC&color=fff&size=128' WHERE company_name = 'City Hospital';
UPDATE customer SET logo_url = 'https://ui-avatars.com/api/?name=MediLab+Inc&background=random&size=128' WHERE logo_url IS NULL;

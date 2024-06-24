INSERT INTO public.client (id, name, checkout) VALUES (2, 'Mattias Marin', '{2022-09-22, 2024-05-26, 2024-05-26, 2024-06-24, 2024-06-24}');
INSERT INTO public.client (id, name, checkout) VALUES (3, 'Paul Poli', '{2022-09-22}');
INSERT INTO public.client (id, name, checkout) VALUES (4, 'Mary Nio', '{2022-09-22, 2024-05-26, 2024-06-24}');
INSERT INTO public.client (id, name, checkout) VALUES (5, 'Lia Yud', '{2022-09-22}');
INSERT INTO public.client (id, name, checkout) VALUES (6, 'Karine Krepim', '{2022-09-22}');

INSERT INTO public.cagnotte(id, amount, client_id) VALUES (1, 15.0, 2);
INSERT INTO public.cagnotte(id, amount, client_id) VALUES (2, 0, 3);
INSERT INTO public.cagnotte(id, amount, client_id) VALUES (3, 10.0, 4);
INSERT INTO public.cagnotte(id, amount, client_id) VALUES (4, 5.0, 5);
INSERT INTO public.cagnotte(id, amount, client_id) VALUES (5, 3.0, 6);
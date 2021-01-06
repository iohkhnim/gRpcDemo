--
-- PostgreSQL database dump
--

-- Dumped from database version 12.2
-- Dumped by pg_dump version 12.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 50
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: product; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.product (
    id smallint,
    name character varying(128) DEFAULT NULL::character varying,
    description character varying(128) DEFAULT NULL::character varying,
    createdtime character varying(128) DEFAULT NULL::character varying,
    updatedtime character varying(128) DEFAULT NULL::character varying
);


ALTER TABLE public.product OWNER TO postgres;

--
-- Data for Name: product; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.product (id, name, description, createdtime, updatedtime) FROM stdin;
21	MACBOOK 2020 64GB		2019-12-11 03:52:04	2019-12-11 03:54:01
22	MSI 2019 8GB RAM DDR4 1TB HDD		2019-12-11 03:55:06	2019-12-11 03:55:06
23	DELL INSPIRATION 16 GB RAM DDR4 1TB HDD		2019-12-11 04:00:15	2019-12-11 04:00:15
24	DELL INSPIRATION 16 GB RAM DDR4 1TB HDD		2019-12-11 04:00:24	2019-12-11 04:00:24
25	DELL		2019-12-11 04:02:34	2019-12-11 04:02:34
26	DELL		2019-12-11 04:03:56	2019-12-11 04:04:17
27	post from web 2	post from web 222	2019-12-11 06:57:54	2019-12-29 13:33:52
30	post from web 27	post from web 222777	2019-12-29 15:54:28	2019-12-29 15:54:28
51	Khoi test 2021	Khoi test sp 2021	2021-01-05 15:55:05.159+00	2021-01-05 15:55:05.159+00
52	Khoi test 2021	Khoi test sp 2021	2021-01-05 15:56:12.137+00	2021-01-05 15:56:12.137+00
53	Khoi test 2021	Khoi test sp 2021	2021-01-05 15:58:32.853+00	2021-01-05 15:58:32.853+00
54	Khoi test 2021	Khoi test sp 2021	2021-01-05 16:03:47.004+00	2021-01-05 16:03:47.004+00
\.


--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 54, true);


--
-- PostgreSQL database dump complete
--


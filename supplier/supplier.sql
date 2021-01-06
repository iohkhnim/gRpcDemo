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
-- Name: supplier; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.supplier (
    id smallint,
    name character varying(17) DEFAULT NULL::character varying,
    address character varying(30) DEFAULT NULL::character varying,
    created_at character varying(19) DEFAULT NULL::character varying,
    updated_at character varying(19) DEFAULT NULL::character varying
);


ALTER TABLE public.supplier OWNER TO postgres;

--
-- Name: supplier_product; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.supplier_product (
    id smallint,
    supplier_id smallint,
    product_id smallint
);


ALTER TABLE public.supplier_product OWNER TO postgres;

--
-- Data for Name: supplier; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.supplier (id, name, address, created_at, updated_at) FROM stdin;
1	Nhà cung cấp fake	200/20 abc phường xyz quận nmn	2019-03-05 06:00:00	2019-03-05 06:00:00
\.


--
-- Data for Name: supplier_product; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.supplier_product (id, supplier_id, product_id) FROM stdin;
16	1	21
17	1	22
18	1	26
19	1	27
\.


--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 50, false);


--
-- PostgreSQL database dump complete
--


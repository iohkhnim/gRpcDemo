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
-- Name: price; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.price (
    id smallint,
    product_id smallint,
    price integer,
    created_at character varying(128) DEFAULT NULL::character varying,
    updated_at character varying(128) DEFAULT NULL::character varying
);


ALTER TABLE public.price OWNER TO postgres;

--
-- Data for Name: price; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.price (id, product_id, price, created_at, updated_at) FROM stdin;
36	21	20000000	2019-12-11 03:52:04	2019-12-11 03:52:04
37	22	15000000	2019-12-11 03:55:06	2019-12-11 03:55:06
38	23	25000000	2019-12-11 04:00:15	2019-12-11 04:00:15
39	24	25000000	2019-12-11 04:00:24	2019-12-11 04:00:24
40	25	1200000	2019-12-11 04:02:34	2019-12-11 04:02:34
41	26	1200000	2019-12-11 04:03:56	2019-12-11 04:03:56
42	27	20000000	2019-12-11 06:57:55	2019-12-11 06:57:55
45	27	10000	2019-12-29 13:28:59	2019-12-29 13:28:59
46	30	10000	2019-12-29 15:54:28	2019-12-29 15:54:28
\N	52	20212021	2021-01-05 15:56:12.145+00	2021-01-05 15:56:12.145+00
\N	53	20212021	2021-01-05 15:58:32.859+00	2021-01-05 15:58:32.86+00
50	54	20212021	2021-01-05 16:03:47.228+00	2021-01-05 16:03:47.228+00
\.


--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 50, true);


--
-- PostgreSQL database dump complete
--


DROP TABLE IF EXISTS univeristy_table;
CREATE TABLE public.univeristy_table (
    "universityId" integer DEFAULT 0 NOT NULL,
    "name " character(100) NOT NULL
);

DROP TABLE IF EXISTS faculty_table;
CREATE TABLE public.faculty_table (
    "facultyId" integer NOT NULL,
    name character(30) NOT NULL,
    "universityId" integer NOT NULL
);

DROP TABLE IF EXISTS teacher_table;
CREATE TABLE public.teacher_table (
    "teacherId" integer NOT NULL,
    name character(30) NOT NULL,
    surname character(30) NOT NULL,
    "facultyId" integer NOT NULL
);

DROP TABLE IF EXISTS vote_table;
CREATE TABLE public.vote_table (
    "voteId" integer NOT NULL,
    attractiveness integer NOT NULL,
    competency integer NOT NULL,
    difficulty integer NOT NULL,
    friendship integer NOT NULL,
    system integer NOT NULL,
    classes integer NOT NULL,
    "comment" character(1000) NOT NULL, 
	"teacherId" integer NOT NULL
);


ALTER TABLE ONLY public.faculty_table
    ADD CONSTRAINT faculty_table_pkey PRIMARY KEY ("facultyId");

ALTER TABLE ONLY public.teacher_table
    ADD CONSTRAINT teacher_table_pkey PRIMARY KEY ("teacherId");

ALTER TABLE ONLY public.univeristy_table
    ADD CONSTRAINT univeristy_table_pkey PRIMARY KEY ("universityId");

ALTER TABLE ONLY public.vote_table
    ADD CONSTRAINT vote_table_pkey PRIMARY KEY ("voteId");

CREATE INDEX "fki_universityId" ON public.faculty_table USING btree ("universityId");

ALTER TABLE ONLY public.teacher_table
    ADD CONSTRAINT "facultyId" FOREIGN KEY ("facultyId") REFERENCES public.faculty_table("facultyId");

ALTER TABLE ONLY public.vote_table
    ADD CONSTRAINT "teacher" FOREIGN KEY ("voteId") REFERENCES public.teacher_table("teacherId");

ALTER TABLE ONLY public.faculty_table
    ADD CONSTRAINT "universityId" FOREIGN KEY ("universityId") REFERENCES public.univeristy_table("universityId");


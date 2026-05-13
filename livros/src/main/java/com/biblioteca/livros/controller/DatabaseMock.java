package com.biblioteca.livros.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.biblioteca.livros.domain.Autores;
import com.biblioteca.livros.domain.Livros;
import com.biblioteca.livros.domain.Usuarios;

public class DatabaseMock {

        public static final List<Autores> autores = new ArrayList<>();
        public static final List<Livros> livros = new ArrayList<>();
        public static final List<Usuarios> usuarios = new ArrayList<>();

        static {
                // --- INSTANCIANDO OS AUTORES ---
                Autores machado = new Autores(1L, "Machado de Assis", "Brasileira",
                                "Maior nome do realismo brasileiro.",
                                LocalDate.parse("1839-06-21"), new ArrayList<>());
                Autores asimov = new Autores(2L, "Isaac Asimov", "Russo-Americana",
                                "Mestre da ficção científica e robótica.",
                                LocalDate.parse("1920-01-02"), new ArrayList<>());
                Autores tolkien = new Autores(3L, "J.R.R. Tolkien", "Britânica", "Criador da alta fantasia moderna.",
                                LocalDate.parse("1892-01-03"), new ArrayList<>());
                Autores clarice = new Autores(4L, "Clarice Lispector", "Brasileira",
                                "Importante escritora do modernismo.",
                                LocalDate.parse("1920-12-10"), new ArrayList<>());
                Autores orwell = new Autores(5L, "George Orwell", "Britânica", "Famoso por suas distopias políticas.",
                                LocalDate.parse("1903-06-25"), new ArrayList<>());
                Autores christie = new Autores(6L, "Agatha Christie", "Britânica", "A Rainha do Crime.",
                                LocalDate.parse("1890-09-15"), new ArrayList<>());
                Autores king = new Autores(7L, "Stephen King", "Americana", "Mestre do terror contemporâneo.",
                                LocalDate.parse("1947-09-21"), new ArrayList<>());

                // --- INSTANCIANDO OS LIVROS ---
                // Machado de Assis
                Livros l1 = new Livros(101L, "Dom Casmurro", null, machado, Arrays.asList("Realismo", "Clássico"), true,
                                1899);
                Livros l5 = new Livros(105L, "Memórias Póstumas de Brás Cubas", null, machado,
                                Arrays.asList("Realismo"), true,
                                1881);
                Livros l6 = new Livros(106L, "Quincas Borba", null, machado, Arrays.asList("Realismo"), true, 1891);

                // Isaac Asimov
                Livros l2 = new Livros(102L, "Fundação", "O Início da Saga", asimov, Arrays.asList("Sci-Fi", "Espaço"),
                                false,
                                1951);
                Livros l4 = new Livros(104L, "Eu, Robô", "As Três Leis", asimov, Arrays.asList("Sci-Fi", "IA"), true,
                                1950);
                Livros l7 = new Livros(107L, "O Fim da Eternidade", null, asimov, Arrays.asList("Sci-Fi", "Tempo"),
                                true, 1955);

                // J.R.R. Tolkien
                Livros l3 = new Livros(103L, "O Hobbit", "Lá e de Volta Outra Vez", tolkien,
                                Arrays.asList("Fantasia", "Aventura"), true, 1937);
                Livros l8 = new Livros(108L, "A Sociedade do Anel", "O Senhor dos Anéis", tolkien,
                                Arrays.asList("Fantasia"),
                                true, 1954);
                Livros l9 = new Livros(109L, "As Duas Torres", "O Senhor dos Anéis", tolkien, Arrays.asList("Fantasia"),
                                true,
                                1954);
                Livros l10 = new Livros(110L, "O Retorno do Rei", "O Senhor dos Anéis", tolkien,
                                Arrays.asList("Fantasia"),
                                true, 1955);

                // Clarice Lispector
                Livros l11 = new Livros(111L, "A Hora da Estrela", null, clarice, Arrays.asList("Modernismo", "Drama"),
                                true,
                                1977);
                Livros l12 = new Livros(112L, "Perto do Coração Selvagem", null, clarice, Arrays.asList("Modernismo"),
                                true,
                                1943);

                // George Orwell
                Livros l13 = new Livros(113L, "1984", "Big Brother is watching you", orwell,
                                Arrays.asList("Distopia", "Político"), true, 1949);
                Livros l14 = new Livros(114L, "A Revolução dos Bichos", null, orwell, Arrays.asList("Sátira", "Fábula"),
                                true,
                                1945);

                // Agatha Christie
                Livros l15 = new Livros(115L, "O Assassinato no Expresso do Oriente", "Hercules Poirot", christie,
                                Arrays.asList("Mistério", "Crime"), true, 1934);
                Livros l16 = new Livros(116L, "E Não Sobrou Nenhum", null, christie,
                                Arrays.asList("Suspense", "Mistério"),
                                true, 1939);
                Livros l17 = new Livros(117L, "Morte no Nilo", null, christie, Arrays.asList("Mistério"), true, 1937);

                // Stephen King
                Livros l18 = new Livros(118L, "O Iluminado", null, king, Arrays.asList("Terror", "Suspense"), true,
                                1977);
                Livros l19 = new Livros(119L, "It: A Coisa", null, king, Arrays.asList("Terror", "Sobrenatural"), true,
                                1986);
                Livros l20 = new Livros(120L, "Misery", null, king, Arrays.asList("Thriller"), true, 1987);

                // --- VINCULANDO OBRAS AOS AUTORES (Importante para integridade dos dados) ---
                machado.getObras().addAll(Arrays.asList(l1, l5, l6));
                asimov.getObras().addAll(Arrays.asList(l2, l4, l7));
                tolkien.getObras().addAll(Arrays.asList(l3, l8, l9, l10));
                clarice.getObras().addAll(Arrays.asList(l11, l12));
                orwell.getObras().addAll(Arrays.asList(l13, l14));
                christie.getObras().addAll(Arrays.asList(l15, l16, l17));
                king.getObras().addAll(Arrays.asList(l18, l19, l20));

                // --- ALIMENTANDO AS LISTAS GLOBAIS ---
                autores.addAll(Arrays.asList(machado, asimov, tolkien, clarice, orwell, christie, king));

                livros.addAll(Arrays.asList(
                                l1, l2, l3, l4, l5, l6, l7, l8, l9, l10,
                                l11, l12, l13, l14, l15, l16, l17, l18, l19, l20));

                // --- INSTANCIANDO USUÁRIOS ---
                usuarios.add(new Usuarios(1L, "734.192.580-44", "Carlos Andrade", 3,
                                new ArrayList<>(Arrays.asList(l2))));
                usuarios.add(new Usuarios(2L, "109.432.765-81", "Mariana Lima", 5, new ArrayList<>()));
                usuarios.add(new Usuarios(3L, "452.001.398-20", "Beatriz Rocha", 2,
                                new ArrayList<>(Arrays.asList(l1))));
                usuarios.add(new Usuarios(4L, "221.345.678-90", "Ricardo Alves", 4,
                                new ArrayList<>(Arrays.asList(l13, l14))));
                usuarios.add(new Usuarios(5L, "332.456.789-01", "Julia Costa", 1, new ArrayList<>(Arrays.asList(l18))));
                usuarios.add(new Usuarios(6L, "443.567.890-12", "Felipe Melo", 0, new ArrayList<>()));
                usuarios.add(
                                new Usuarios(7L, "554.678.901-23", "Patrícia Gomes", 6,
                                                new ArrayList<>(Arrays.asList(l3, l8, l9))));
                usuarios.add(new Usuarios(8L, "665.789.012-34", "Roberto Dias", 2,
                                new ArrayList<>(Arrays.asList(l15))));
                usuarios.add(new Usuarios(9L, "776.890.123-45", "Fernanda Souza", 3,
                                new ArrayList<>(Arrays.asList(l11))));
                usuarios.add(new Usuarios(10L, "887.901.234-56", "Lucas Martins", 5,
                                new ArrayList<>(Arrays.asList(l4, l7))));
                usuarios.add(new Usuarios(11L, "998.012.345-67", "Camila Oliveira", 1,
                                new ArrayList<>(Arrays.asList(l19))));
                usuarios.add(new Usuarios(12L, "123.456.789-00", "Bruno Silva", 2,
                                new ArrayList<>(Arrays.asList(l10))));
                usuarios.add(new Usuarios(13L, "234.567.890-11", "Amanda Nunes", 4,
                                new ArrayList<>(Arrays.asList(l16, l17))));
                usuarios.add(new Usuarios(14L, "345.678.901-22", "Gabriel Santos", 3,
                                new ArrayList<>(Arrays.asList(l5, l6))));
                usuarios.add(new Usuarios(15L, "456.789.012-33", "Larissa Meira", 0, new ArrayList<>()));
                usuarios.add(new Usuarios(16L, "567.890.123-44", "Tiago Ferreira", 2,
                                new ArrayList<>(Arrays.asList(l12))));
                usuarios.add(new Usuarios(17L, "678.901.234-55", "Vanessa Lima", 5,
                                new ArrayList<>(Arrays.asList(l20))));
                usuarios.add(new Usuarios(18L, "789.012.345-66", "Henrique Vaz", 1,
                                new ArrayList<>(Arrays.asList(l2))));
                usuarios.add(new Usuarios(19L, "890.123.456-77", "Sônia Braga", 3, new ArrayList<>(Arrays.asList(l1))));
                usuarios.add(new Usuarios(20L, "901.234.567-88", "Renan Castro", 4,
                                new ArrayList<>(Arrays.asList(l13))));
        }
}
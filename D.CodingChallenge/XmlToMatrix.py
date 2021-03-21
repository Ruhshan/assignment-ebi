from prettytable import PrettyTable
import xml.etree.ElementTree as ET


class Matrix:
    index = {}
    rows = []
    items = []

    def __init__(self, items):
        self.items = items
        i = 0
        item_len = len(items)
        for item in items:
            self.index[item] = i
            i += 1
            self.rows.append([0] * item_len)

    def cell_increment(self, row, col):
        self.rows[self.index[row]][self.index[col]] += 1

    def __str__(self):
        table = PrettyTable()
        table.field_names = [""] + self.items

        for i in range(len(self.rows)):
            table.add_row([self.items[i]] + self.rows[i])
        return table.get_string()


class XmlToMatrix:
    authors_in_article = {}
    articles_by_author = {}

    def __init__(self, xml_path):
        tree = ET.parse(xml_path)
        articles = tree.getroot()
        for article in articles:
            article_title = article[0].text
            authors_list = article[1]
            for author in authors_list:
                author_name = "{}, {}".format(author[0].text, author[1].text)
                try:
                    self.authors_in_article[article_title].append(author_name)
                except KeyError:
                    self.authors_in_article[article_title] = [author_name]

                try:
                    self.articles_by_author[author_name].append(article_title)
                except KeyError:
                    self.articles_by_author[author_name] = [article_title]

    def create_co_author_matrix(self, authors):
        return Matrix(authors)

    def get_all_co_authors(self, author):
        co_authors = []
        articles = self.articles_by_author[author]
        for article in articles:
            for co_author in self.authors_in_article[article]:
                co_authors.append(co_author)
        return co_authors

    def generate_matrix(self):
        all_authors = list(self.articles_by_author.keys())
        matrix = self.create_co_author_matrix(all_authors)

        for author in all_authors:
            for co_author in self.get_all_co_authors(author):
                matrix.cell_increment(author, co_author)

        return matrix


if __name__ == "__main__":
    xmlToMatrix = XmlToMatrix("articles.xml")
    print(xmlToMatrix.generate_matrix())

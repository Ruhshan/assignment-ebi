from prettytable import PrettyTable

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
            i+=1
            self.rows.append([0]*item_len)

    def cell_increment(self,row, col):
        self.rows[self.index[row]][self.index[col]]+=1


    def __str__(self):
        table = PrettyTable()
        table.field_names = [""]+self.items

        for i in range(len(self.rows)):
            table.add_row([self.items[i]]+self.rows[i])
        return table.get_string()



class XmlToMatrix:
    def __init__(self):
        pass

    def get_authors_in_article(self):
        data = {
            "Title 1" : ["Public, JQ", "Doe, John"],
            "Title 2" : ["Doe, John", "Doe, Jane"],
            "Title 3" : ["Doe, Jane", "Public, JQ"],
            "Title 4" : ["Smith, John", "Doe, John"]
        }

        return data

    def get_articles_by_author(self):
        data = {
            "Public, JQ":["Title 1","Title 3"],
            "Doe, John":["Title 1","Title 2","Title 4"],
            "Doe, Jane":["Title 2","Title 3"],
            "Smith, John":["Title 4"]
        }

        return data

    def create_co_author_matrix(self, authors):
        return Matrix(authors)

    def get_all_co_authors(self, author, authors_in_article, articles_by_author):
        co_authors = []
        articles = articles_by_author[author]
        for article in articles:
            for co_author in authors_in_article[article]:
                co_authors.append(co_author)
        return co_authors



if __name__ == "__main__":
    xmlTomatrix = XmlToMatrix()
    authors_in_article = xmlTomatrix.get_authors_in_article()
    articles_by_author = xmlTomatrix.get_articles_by_author()

    all_authors = list(articles_by_author.keys())

    matrix = xmlTomatrix.create_co_author_matrix(all_authors)

    for author in all_authors:
        for co_author in xmlTomatrix.get_all_co_authors(author, authors_in_article, articles_by_author):
            matrix.cell_increment(author, co_author)

    print(matrix)








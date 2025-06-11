import copy


class IBTree_small:
    def __init__(self, num_levels):
        self.num_levels = num_levels
        self.structure = [None] * num_levels
        # 初始化指针组模板，不可以修改，只可以复制使用副本
        self.pointer_group_template = [0] * num_levels

    # 一个让输入的与指针组模板同类的指针组向指针增加的方向前进一步(前进到下一个1)的函数
    def pointer_group_step(self, pointer_group):
        inside = True
        i = self.num_levels - 1
        while inside:
            if not pointer_group[i] & 1:
                if self.structure[i][pointer_group[i + 1]]:
                    pointer_group[i] += 1
                    inside = False
                else:
                    pointer_group[i] += 2
                    while not self.structure[i][pointer_group[i]]:
                        pointer_group[i] += 1
            else:
                pointer_group[i] += 1
                while not self.structure[i][pointer_group[i]]:
                    pointer_group[i] += 1


            if pointer_group[i] & 1:
                pointer_group[i] += 1
                while not self.structure[i][pointer_group[i]]:
                    pointer_group[i] += 1
            elif not self.structure[i][pointer_group[i + 1]]:
                pointer_group[i] += 2
                while not self.structure[i][pointer_group[i]]:
                    pointer_group[i] += 1
            else:
                pointer_group[i] += 1
                inside = False

    def branch_grow(self, index_list):
        pointer_group = copy.deepcopy(self.pointer_group_template)
        while pointer_group[0] < 2:


w = IBTree_small(4)
index_list = [[0, 0, 1, 1], [0, 1, 0, 0], [1, 1, 0, 1]]
w.branch_grow(index_list)
# w = IBTree_small(6)
